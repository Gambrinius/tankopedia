(ns tankopedia.repositories.tank_repository
    (:require [compojure.core :refer :all]
              [clojure.java.jdbc :as jdbc]
              [tankopedia.db.core :as db]
              [tankopedia.models.model :as model]
              [tankopedia.repositories.base_repository :as baseRepository]))

(defrecord TankRepositoryImpl [db-spec]
  baseRepository/BaseRepository

  (find-by-id [this id]
    (let [tank-item (first (jdbc/query db-spec ["SELECT tank_id, tank_health, tank_name, tank_weight, tank_level, tank_premium,
                                                        tank_price, tank_small_icon, tank_big_icon, cat.c_name as tank_category, c.c_name as tank_country
                                                        FROM dbo.tank AS t
                                                        JOIN dbo.category AS cat ON cat.c_id = t.tank_category_id
                                                        JOIN dbo.country AS c ON c.c_id = t.tank_country_id
                                                        WHERE tank_id = ?" id]))]
      (model/->Tank (tank-item  :tank_id) (tank-item :tank_health) (tank-item :tank_name)
                    (tank-item :tank_weight) (tank-item :tank_level) (tank-item :tank_premium)
                    (tank-item :tank_price) (tank-item :tank_small_icon) (tank-item :tank_big_icon)
                    (tank-item :tank_category) (tank-item :tank_country))))

  (find-all [this]
    (let [tanks-list (jdbc/query db-spec ["SELECT tank_id, tank_health, tank_name, tank_weight, tank_level, tank_premium,
                                                  tank_price, tank_small_icon, tank_big_icon, cat.c_name as tank_category, c.c_name as tank_country
                                                  FROM dbo.tank AS t
                                                  JOIN dbo.category AS cat ON cat.c_id = t.tank_category_id
                                                  JOIN dbo.country AS c ON c.c_id = t.tank_country_id"])]
      (for [tank-item tanks-list]
        (model/->Tank (tank-item  :tank_id) (tank-item :tank_health) (tank-item :tank_name) (tank-item :tank_weight)
                      (tank-item :tank_level) (tank-item :tank_premium) (tank-item :tank_price) (tank-item :tank_small_icon)
                      (tank-item :tank_big_icon) (tank-item :tank_category) (tank-item :tank_country))))))

(def tankRepositoryComponent (->TankRepositoryImpl  db/db-spec))
