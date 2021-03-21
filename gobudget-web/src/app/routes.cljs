(ns app.routes
  (:require [app.transactions.views.transactions :refer [transactions]]
            [app.auth.views.profile :refer [profile]]))

(defn routes
  [page-name]
  (case page-name
    :transactions [transactions]
    [profile]))
