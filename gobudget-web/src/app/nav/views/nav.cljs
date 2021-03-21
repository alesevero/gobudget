(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenticated]]
            [app.nav.views.public :refer [public]]
            [app.nav.views.styles :refer [container]]))

(defn header
  [navigation]
  [:div container
   [:img {:src "assets/logo.svg" :alt "GoBudget"}]
   [navigation]])

(defn nav
  []
  (let [logged-in? true]
    (if logged-in?
      [header authenticated]
      [header public])))
