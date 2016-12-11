(ns tankopedia.db.core)
    (require '[clojure.java.jdbc :as jdbc])
;; you can optionally specify :host and :port to override the defaults
;; of "127.0.0.1" and 1433 respectively:
(def db-spec {:dbtype   "mssql"
              :host     "localhost"
              :port     "52320"
              :dbname   "TANKDATABASE"
              :user     "DBTANK"
              :password "1234"})


(defn get-tanks []
  (jdbc/query db-spec
              ["SELECT * FROM TANKDATABASE.dbo.tank"])
  )

(comment (ns tankopedia.db.core
  (:require
    [conman.core :as conman]
    [mount.core :refer [defstate]]
    [tankopedia.config :refer [env]]))

(defstate ^:dynamic *db*
          :start (conman/connect! {:jdbc-url (env {:database-url "jdbc:sqlserver://localhost:52320;database=TANKDATABASE;user=DBTAN;password=1234"})})
          :stop (conman/disconnect! *db*))

(conman/bind-connection *db* "sql/queries.sql")

         )