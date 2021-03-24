(ns app.views.navigation.nav
  (:require [app.views.navigation.styles :refer [container]]))

(defn header
  [navigation logged-in?]
  [:div container
   (when logged-in?  [:img {:src "assets/logo.svg" :alt "GoBudget"}])
   [navigation]])