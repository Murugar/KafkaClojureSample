(defproject KafkaClojureTest "0.1.0-SNAPSHOT"
  :description "Kafka Clojure Test"
  :url "http://com.iqmsoft"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.2.374"]
                 [com.stuartsierra/component "0.3.1"]
                 [environ "1.0.2"]
                 [com.taoensso/timbre "4.3.1"]
                 [faker "0.2.2"]
                 ; [clj-kafka "0.3.4"]
                 ; [kafka-clj "3.6.2"]
                 [ymilky/franzy "0.0.1"]]
  :main ^:skip-aot clojurekafka.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
