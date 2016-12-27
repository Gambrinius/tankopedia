(ns tankopedia.controllers.tank_controller
  (:require [tankopedia.layout :as layout]
            [tankopedia.repositories.tank_repository :as tankRepository]
            [tankopedia.repositories.base_repository :as baseRepository]))


(defn get-tank-by-id [request id]
  (let [tank-item (baseRepository/find-by-id tankRepository/tankRepositoryComponent id)]
    (layout/render
      request "tank.html" {:tank tank-item})))

(defn get-tanks [request]
  (let [tanks-list (baseRepository/find-all tankRepository/tankRepositoryComponent)]
    (layout/render
      request "tanks.html" {:tanks tanks-list})))
