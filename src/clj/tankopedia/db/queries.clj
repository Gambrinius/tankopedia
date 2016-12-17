(ns tankopedia.db.queries
(:require [clojure.java.jdbc :as jdbc]
          [tankopedia.db.core :as core]))

#_
  (defn get-tanks []
    (jdbc/query core/db-spec
                ["SELECT * FROM TANKDATABASE.dbo.tank"]))
