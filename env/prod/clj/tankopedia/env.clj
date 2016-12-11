(ns tankopedia.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[tankopedia started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[tankopedia has shut down successfully]=-"))
   :middleware identity})
