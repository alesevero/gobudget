(ns app.nav.views.authenticated
  (:require [app.nav.components.nav-item :refer [nav-item]]
            [re-frame.core :as rf]
            [app.nav.views.styles :refer [header]]))

(defn authenticated
  []
  (let [active-nav @(rf/subscribe [:active-nav])
        nav-items [{:id :transactions
                    :name "Transactions"
                    :href "#transactions"
                    :dispatch #(rf/dispatch [:set-active-nav :transactions])}
                   {:id :profile
                    :name "Profile"
                    :href "#profile"
                    :dispatch #(rf/dispatch [:set-active-nav :profile])}]]
    [:div header
     (for [{:keys [id name dispatch href]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :dispatch dispatch
                  :href href
                  :active-nav active-nav}])]))
