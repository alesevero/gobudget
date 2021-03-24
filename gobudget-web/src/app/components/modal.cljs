(ns app.components.modal
  (:require [re-frame.core :as rf]))

(defn modal-panel
  [{:keys [child show?]}]
  [:div {:class "modal-wrapper"}
   [:div {:class "modal-backdrop"
          :on-click (fn [event]
                      (rf/dispatch [:modal {:show? (not show?)
                                            :child nil
                                            :size :default}])
                      (.preventDefault event)
                      (.stopPropagation event))}]
   [:div {:class "modal-child"}
    child]])

(defn open-modal
  [child]
  (rf/dispatch [:modal {:show? true :child child}]))