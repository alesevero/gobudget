(ns app.components.nav-item)

(defn nav-item
  [{:keys [id href name dispatch active-nav style]}]
  [:a (merge (style id active-nav)
             {:key id
              :href href
              :on-click dispatch})
   name])