(ns app.navigation.routes
  (:require [app.views.home.transactions :refer [transactions]]
            [app.views.profile.profile :refer [profile]]
            [app.views.auth.sign-up :refer [sign-up]]
            [app.views.auth.log-in :refer [log-in]]
            [app.views.about.about :refer [about]]))

(defn routes
  [page-name]
  (case page-name
    :profile [profile]
    :transactions [transactions]
    :sign-up [sign-up]
    :sign-in [log-in]
    :about [about]
    [sign-up]))
