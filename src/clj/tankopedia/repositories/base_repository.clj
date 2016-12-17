(ns tankopedia.repositories.base_repository)

(defprotocol BaseRepository
  (find-all [this])
  (find-by-id [this id])
  (add [this model])
  (delete [this id]))