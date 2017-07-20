(ns clojurekafka.core
  (:require [clojurekafka
             [producer :as p]
             [source   :as s]]
            [environ.core :refer [env]]
            [com.stuartsierra.component :as component])
  (:gen-class))

(defn- add-shutdown-hook!
  [f]
  (doto (Runtime/getRuntime)
    (.addShutdownHook (Thread. f))))

(def config
  {:kafka-bootstrap-server (or (env :kafka-bootstrap-server)
                               "localhost:9092")})

(defn make-system [config]
  (component/system-map
   :source   (s/make-source)
   :producer (component/using
              (p/make-producer config)
              [:source])))

(defn -main
  [& args]
  (let [system (component/start (make-system config))
        lock   (promise)]
    (add-shutdown-hook! #(do (component/stop system)
                             (deliver lock :done)))
    @lock
    (System/exit 0)))
