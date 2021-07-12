(ns app.views.navigation.authenticated
  (:require [app.components.nav-item :refer [nav-item]]
            [re-frame.core :as rf]
            [app.views.navigation.styles :refer [header
                                                 profile-link
                                                 profile-img
                                                 link]]))

(defn authenticated
  []
  (let [active-nav @(rf/subscribe [:active-nav])
        nav-items [{:id :transactions
                    :name "Transactions"
                    :href "#transactions"
                    :dispatch #(rf/dispatch [:set-active-nav :transactions])}
                   {:id :about
                    :name "About"
                    :href "#about"
                    :dispatch #(rf/dispatch [:set-active-nav :about])}
                   {:id :sign-in
                    :name "Log out"
                    :href "#sign-in"
                    :dispatch #(rf/dispatch [:set-active-nav :log-out])}]]
    [:div header
     (for [{:keys [id name dispatch href]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :dispatch dispatch
                  :href href
                  :active-nav active-nav
                  :style link}])
     [:a (merge (profile-link active-nav)
                {:href "#profile"
                 :on-click #(rf/dispatch [:set-active-nav :profile])})
      [:img (merge profile-img
                   {:src "assets/avatar.png" :alt "Avatar"})]]]))
