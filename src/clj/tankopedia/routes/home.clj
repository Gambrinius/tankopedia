(ns tankopedia.routes.home
  (:require [tankopedia.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [tankopedia.db.queries :as db]
            [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.tank_repository :as tankRepository]
            [tankopedia.models.model :as model]
            [tankopedia.controllers.user_controller :as userController]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn get-tank-by-id [id]
  (let [tank-item (baseRepository/find-by-id tankRepository/tankRepositoryComponent id)]
  (layout/render
    "tank.html" {:tank tank-item})))

(defn get-tanks []
  (let [tanks-list (baseRepository/find-all tankRepository/tankRepositoryComponent )]
    (layout/render
      "tanks.html" {:tanks tanks-list})))


(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/tanks" [] (get-tanks))
  (GET "/tank/:id" [id] (get-tank-by-id id))
  (GET "/users" [] (userController/get-users))
  (GET "/registration" [] (userController/registration-page nil))
  (POST "/registration" [& params] (userController/registration-post params))         )
