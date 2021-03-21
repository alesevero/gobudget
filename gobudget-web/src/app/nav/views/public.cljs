(ns app.nav.views.public
  (:require [re-frame.core :as rf]
            [app.nav.components.nav-item :refer [nav-item]]
            [app.nav.views.styles :refer [header]]))

(defn public
  []
  (let [active-nav @(rf/subscribe [:active-nav])
        nav-items [{:id :sign-up
                    :name "Sign Up"
                    :href "#sign-up"
                    :dispatch #(rf/dispatch [:set-active-nav :sign-up])}
                   {:id :sign-in
                    :name "Sign In"
                    :href "#sign-in"
                    :dispatch #(rf/dispatch [:set-active-nav :sign-in])}]]
    [:div header
     (for [{:keys [id name dispatch href]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :dispatch dispatch
                  :href href
                  :active-nav active-nav}])]))