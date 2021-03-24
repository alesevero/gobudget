(ns app.navigation.routes
  (:require [app.views.home.transactions :refer [transactions]]
            [app.views.profile.profile :refer [profile]]
            [app.views.auth.sign-up :refer [sign-up]]
            [app.views.auth.log-in :refer [log-in]]))

(defn routes
  [page-name]
  (case page-name
    :profile [profile]
    :transactions [transactions]
    :sign-up [sign-up]
    :sign-in [log-in]
    [sign-up]))
