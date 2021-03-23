(ns app.auth.views.styles)

(def container
  {:style {:width "100%"
           :padding "30px 0"
           :display "flex"
           :align-items "center"
           :justify-content "center"}})

(def auth-container
  {:style {:width "900px"
           :padding "30px 0"
           :display "flex"
           :align-items "flex-start"
           :justify-content "space-between"}})

(def side-title-container
  {:style {:display "flex"
           :flex-direction "column"}})

(def form-container
  {:style {:width "400px"}})

(def sign-up-link
  {:style {:font-size "12px"
           :text-decoration "none"
           :color "#C18E60"}})

(def auth-button
  {:style {:border "0"
           :border-radius "8px"
           :padding "8px"
           :background-color "#24695C"
           :color "#F0F2F5"}})

(defn error-message
  [message]
  [:p {:style {:font-size "16px"
               :color "#e83f5b"}} message])

(def profile-container
  {:style {:width "100%"
           :display "flex"
           :flex-direction "column"
           :align-items "center"
           :justify-content "center"}})

(def profile-title
  {:style {:padding "16px"
           :font-size "28px"
           :color "#363F5F"}})

(def profile-section
  {:style {:width "400px"
           :background-color "#F9F7F6"
           :padding "24px"
           :margin-bottom "32px"
           :border-radius "16px"}})

(def profile-section-title
  {:style {:margin-bottom "16px"
           :color "#363F5F"
           :font-size "18px"
           :font-weight "400"}})

(def button-container
  {:style {:display "flex"
           :justify-content "flex-end"}})

(def profile-button
  {:padding "8px"
   :color "#F9F7F6"
   :border 0
   :border-radius "8px"})

(def update-profile-button
  {:style (merge profile-button
                 {:background-color "#24695C"})})

(def delete-profile-button
  {:style (merge profile-button
                 {:background-color "#e83f5b"})})