import Foundation
import Capacitor
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ActionSheet)
public class ActionSheet: CAPPlugin {
    
    @objc func showActionSheet(_ call: CAPPluginCall) {
        let title = call.getString("title") ?? ""
        let values = call.getArray("values", String.self) ?? []
        
        let alert = UIAlertController(title: title, message: "", preferredStyle: .alert)
    
        for name in values {
            alert.addAction(UIAlertAction(title: name, style: .default , handler:{ (UIAlertAction)in
                call.success([
                    "result": name
                ])
            }))
        }
       
        DispatchQueue.main.async {
          self.bridge.viewController.present(alert, animated: true, completion: nil)
        }
        
    }
}
