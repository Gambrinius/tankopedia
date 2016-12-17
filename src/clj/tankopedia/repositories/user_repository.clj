(ns tankopedia.repositories.user_repository
  (:require [compojure.core :refer :all]
            [clojure.java.jdbc :as jdbc]
            [tankopedia.db.core :as db]
            [tankopedia.models.model :as model]
            [tankopedia.repositories.base_repository :as baseRepository]))




(defprotocol UserRepository
  (find-by-login [this login])
  (find-by-login-and-hash [this login hash]))


(defrecord UserRepositoryImpl [db-spec]
  baseRepository/BaseRepository

  (find-by-id [this id]
    (let [item (first (jdbc/query db-spec ["SELECT u_id, u_login, u_name, u_password, u_role FROM dbo.[user]
                                            WHERE u_id = ?" id]))]
      (model/->User (item :u_id) (item :u_login) (item :u_name) (item :u_password) (item :u_role))))

  (find-all [this]
    (let [items (jdbc/query db-spec ["SELECT u_id, u_login, u_name, u_password, u_role FROM dbo.[user]"])]
      (for [item items]
        (model/->User (item :u_id) (item :u_login) (item :u_name) (item :u_password) (item :u_role)))))

  (add [this model]
    (jdbc/insert! db-spec "dbo.[user]" model))

  (delete [this id] (jdbc/delete! db-spec :user ["u_id = ?" id]))

  UserRepository

  (find-by-login [this login]
    (let [item (first (jdbc/query db-spec ["SELECT u_id, u_login, u_name, u_password, u_role FROM dbo.[user]
                                            WHERE u_login = ?" login]))]
      (model/->User (item :u_id) (item :u_login) (item :u_name) (item :u_password) (item :u_role))))

  (find-by-login-and-hash [this login hash]
    (jdbc/query db-spec ["SELECT u_id, u_login, u_name, u_password, u_role FROM dbo.[user]
                          WHERE u_login = ? AND u_password = ?" login hash])))

(def userRepositoryComponent (->UserRepositoryImpl db/db-spec))