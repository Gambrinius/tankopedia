(ns tankopedia.routes.home
  (:require [tankopedia.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [tankopedia.db.queries :as db]
            [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.tank_repository :as tankRepository]
            [tankopedia.models.model :as model]
            [tankopedia.controllers.user_controller :as userController]
            [tankopedia.repositories.news_repository :as newsRepository]
            [tankopedia.controllers.news_controller :as newsController]
            [tankopedia.dsl.dsl :as dsl]))

(defn home-page [request]
  (newsController/get-latest-news request)
  )

(defn about-page [request]
  (layout/render request "about.html"))


(defroutes home-routes
  (GET "/" [:as request] (home-page request))
  (GET "/about" [:as request] (about-page request))
  (GET "/dsl" [:as request] (dsl/dsl-page request nil))
  (POST "/dsl" [:as request] (dsl/dsl-page-post request))
  )
