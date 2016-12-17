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
