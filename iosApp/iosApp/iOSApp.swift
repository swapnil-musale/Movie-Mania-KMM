import SwiftUI
import shared

@available(iOS 16.0, *)
@main
struct iOSApp: App {
    
    init(){
        KoinHelperKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			MovieListView()
		}
	}
}
