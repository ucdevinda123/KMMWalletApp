//
//  CircleButtonView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI

struct CircleButtonView: View {
    
    var icon = "person.crop.circle"
    
    var body: some View {
        return HStack {
            Image(systemName: icon)
                .foregroundColor(.primary)
        }
        .frame(width: 38, height: 38)
        .background(
            RoundedRectangle(cornerRadius: 25)
                .fill(Color.white)
                .shadow(color: .gray, radius: 2, x: 0, y: 2))
        
    }
}

struct CircleButtonView_Previews: PreviewProvider {
    static var previews: some View {
        CircleButtonView()
    }
}


struct CardButtonView: View {
    
    var icon = ""
    var title = ""
    
    var body: some View {
        VStack {
            Image(icon)
                .foregroundColor(.primary)
            Text(title)
                .fontWeight(.bold)
                .font(.system(size: 14, weight: .light, design: .default))
        }
        .frame(width: 100, height: 100)
        .background(
            RoundedRectangle(cornerRadius: 10)
                .fill(Color.white)
                .shadow(color: .gray, radius: 2, x: 0, y: 2))
    }
}
