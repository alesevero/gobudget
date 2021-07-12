(ns app.navigation.nav
  (:require [app.views.navigation.authenticated :refer [authenticated]]
            [app.views.navigation.public :refer [public]]
            [app.views.navigation.nav :refer [header]]
            [re-frame.core :as rf]))

(defn nav
  []
  (let [logged-in? @(rf/subscribe [:logged-in?])
        active-nav @(rf/subscribe [:active-nav])]
    (if logged-in?
      [header authenticated logged-in? active-nav]
      [header public logged-in?])))
