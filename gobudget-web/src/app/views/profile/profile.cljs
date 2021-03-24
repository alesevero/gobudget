(ns app.views.profile.profile
  (:require [app.components.form-group :refer [form-group]]
            [app.views.profile.styles :refer [container
                                              title
                                              section
                                              section-title
                                              button-container
                                              update-profile-button
                                              delete-profile-button]]
            [re-frame.core :as rf]
            [reagent.core :as r]))

(defn profile
  []
  (let [{:keys [first-name last-name]} @(rf/subscribe [:active-user-profile])
        initial-values {:first-name first-name :last-name last-name}
        values (r/atom initial-values)]
    (fn []
      [:div container
       [:h1 title "Profile"]
       [:div
        [:section section
         [:h4 section-title "Personal Info"]
         [form-group {:id :first-name
                      :label "First Name"
                      :type "text"
                      :values values}]
         [form-group {:id :last-name
                      :label "Last Name"
                      :type "text"
                      :values values}]
         [:div button-container
          [:button (merge update-profile-button
                          {:on-click #(rf/dispatch [:update-profile @values])})
           "Update Profile"]]]
        [:div section
         [:h4 section-title "Danger Zone"]
         [:div button-container
          [:button (merge  delete-profile-button
                           {:on-click #(when (js/confirm "This will delete your account")
                                         (rf/dispatch [:delete-account]))})
           "Delete Account"]]]]])))
