(ns tankopedia.dsl.dsl
  (:use [clojure.edn :as edn])
  (:require [tankopedia.controllers.news_controller :as newsController]
            [tankopedia.layout :as layout]
            [tankopedia.utils.validation :as utils]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [tankopedia.repositories.news_repository :as newsRepository]
            [tankopedia.repositories.base_repository :as baseRepository]))


(defn validate-command [command] (b/validate command
                                                 :command v/required))
(def session (agent {}))

(defn run [request string]
  (send session assoc :request request)
  (try
    (binding [*ns* (find-ns 'tankopedia.dsl.dsl)]
      (load-string (str "(" string ")"))

      )

  (catch Exception e
    (layout/render
        request "dsl.html" {:messages {:ex (str "Bad command: " e)}} ))))

(defn dsl-page [request messages]
  (layout/render
    request "dsl.html" {:messages messages}))

(defn dsl-page-post [request]
  (let [text (get-in request [:form-params "command"])
        command {:command text}
        validation-result (first (validate-command command))]

    (if (nil? validation-result)
      (do
        (run request text)
        )
      (dsl-page request (utils/fix-validation-messages validation-result))
    ))
  )

(defn show-all-news []
  (newsController/get-news (:request @session) )
  )

(defn news-by-id [id]
  (newsController/news-page (:request @session) id nil)
  )