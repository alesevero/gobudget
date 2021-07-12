(ns app.views.navigation.nav
  (:require [app.views.navigation.styles :refer [container]]))

(defn header
  [navigation logged-in? active-nav]
  (let [show-img (and (not (= active-nav :about)) logged-in?)]
    [:div container
     (when show-img [:img {:src "assets/logo.svg" :alt "GoBudget"}])
     [navigation]]))