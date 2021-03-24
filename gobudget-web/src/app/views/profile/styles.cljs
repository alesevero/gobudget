(ns app.views.profile.styles)

(def container
  {:style {:width "100%"
           :display "flex"
           :flex-direction "column"
           :align-items "center"
           :justify-content "center"}})

(def title
  {:style {:padding "16px"
           :font-size "28px"
           :color "#363F5F"}})

(def section
  {:style {:width "400px"
           :background-color "#F9F7F6"
           :padding "24px"
           :margin-bottom "32px"
           :border-radius "16px"}})

(def section-title
  {:style {:margin-bottom "16px"
           :color "#363F5F"
           :font-size "18px"
           :font-weight "400"}})

(def button-container
  {:style {:display "flex"
           :justify-content "flex-end"}})

(def button
  {:padding "8px"
   :color "#F9F7F6"
   :border 0
   :border-radius "8px"})

(def update-profile-button
  {:style (merge button
                 {:background-color "#24695C"})})

(def delete-profile-button
  {:style (merge button
                 {:background-color "#e83f5b"})})
