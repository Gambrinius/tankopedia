(ns user
  (:require [mount.core :as mount]
            tankopedia.core))

(defn start []
  (mount/start-without #'tankopedia.core/repl-server))

(defn stop []
  (mount/stop-except #'tankopedia.core/repl-server))

(defn restart []
  (stop)
  (start))


