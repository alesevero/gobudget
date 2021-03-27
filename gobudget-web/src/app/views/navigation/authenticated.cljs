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
                   {:id :sign-in
                    :name "Log out"
                    :href "#sign-in"
                    :dispatch #(rf/dispatch [:log-out])}]]
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

[:div {:style {:display "flex"
               :align-items "center"
               :justify-content "center"}}
 [:a.profile-avatar-link {:href "#profile"
                          :on-click (.log js/console "Hello, World!")}
  [:img {:src "assets/avatar.png"
         :alt "Avatar"
         :class "profile-avatar-img"}]]]

[:a {:href "#profile"
     :on-click (.log js/console "Hello, World!")}]

(.log js/console "Hello, World!")