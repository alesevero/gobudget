(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenticated]]
            [app.nav.views.public :refer [public]]
            [app.nav.views.styles :refer [container]]
            [re-frame.core :as rf]))

(defn header
  [navigation logged-in?]
  [:div container
   (when logged-in?  [:img {:src "assets/logo.svg" :alt "GoBudget"}])
   [navigation]])

(defn nav
  []
  (let [logged-in? @(rf/subscribe [:logged-in?])]
    (if logged-in?
      [header authenticated logged-in?]
      [header public logged-in?])))
