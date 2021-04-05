//
//  LoadingView.swift
//  iosApp
//
//  Created by Chinthaka on 04/04/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct LoadingView: View {

    var body: some View {
            VStack {
                Spacer()
                Text("loading...")
                Spacer().frame(height: 30)
                if #available(iOS 14.0, *) {
                    ProgressView().progressViewStyle(CircularProgressViewStyle())
                } else {
                    // Fallback on earlier versions
                }
                Spacer()
            }
        }
}
