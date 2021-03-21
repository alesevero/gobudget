(ns app.routes
  (:require [app.transactions.views.transactions :refer [transactions]]
            [app.auth.views.profile :refer [profile]]
            [app.auth.views.sign-up :refer [sign-up]]
            [app.auth.views.log-in :refer [log-in]]))

(defn routes
  [page-name]
  (case page-name
    :profile [profile]
    :transactions [transactions]
    :sign-up [sign-up]
    :sign-in [log-in]
    [sign-up]))
