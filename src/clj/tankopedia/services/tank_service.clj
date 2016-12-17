(ns tankopedia.services.tank_service
  (:use
    :require
    [tankopedia.repositories.tank_repository]
    [ring.util.response :as response]
    ; [modern-cljs.dsl.dsltask]                               ; хз
    )
  (:require  [tankopedia.models.model :as model]
            [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.tank_repository :as tankRepository]
            [clojure.data.json :as json]))

#_
(def browseTankPageState (atom {:tank nil }))

#_
(defn get-tanks [request]
  (let [tank-list (:params request)]
    (baseRepository/find-all tankRepositoryComponent (model/->Tank nil (tank-list  :tank_id) (tank-list :tank_health) (tank-list :tank_name) (tank-list :tank_weight)
                                                                       (tank-list :tank_level) (tank-list :tank_premium) (tank-list :tank_price) (tank-list :tank_small_icon)
                                                                       (tank-list :tank_big_icon) (tank-list :tank_category) (tank-list :tank_country)))))
#_
(defn getBrowseTankPageState [] @browseTankPageState)