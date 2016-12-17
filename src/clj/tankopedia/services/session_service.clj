(ns tankopedia.services.session_service)

(def session-atom (atom {:login nil}))

(defn getSessionMemory []
  session-atom)

(defn register [request]
  (let [requestParams (:params request)]
    (println session-atom)
    (swap! session-atom assoc :login (:login requestParams))
    (println (str "after atom changes... "))
    (println session-atom)))

(defn login [request]
  (let [requestParams (:params request)]
    (println session-atom)
    (swap! session-atom assoc :login (:login requestParams))
    (println (str "after atom changes... "))
    (println session-atom)))

(defn logout [request]
  (let [requestParams (:params request)]
    (println session-atom)
    (swap! session-atom assoc :login (:login requestParams))
    (println (str "after atom changes... "))
    (println session-atom)))
