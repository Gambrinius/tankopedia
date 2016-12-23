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
            [tankopedia.controllers.news_controller :as newsController]))

(defn home-page [request]
  (newsController/get-latest-news request)
  )

(defn about-page [request]
  (layout/render request "about.html"))

(defn get-tank-by-id [id]
  (let [tank-item (baseRepository/find-by-id tankRepository/tankRepositoryComponent id)]
  (layout/render
    "tank.html" {:tank tank-item})))

(defn get-tanks []
  (let [tanks-list (baseRepository/find-all tankRepository/tankRepositoryComponent )]
    (layout/render
      "tanks.html" {:tanks tanks-list})))


(defroutes home-routes
  (GET "/" [:as request] (home-page request))
  (GET "/home" [:as request] (home-page request))
  (GET "/about" [:as request] (about-page request))
  (GET "/tanks" [] (get-tanks))
  (GET "/tank/:id" [id] (get-tank-by-id id))
  )
