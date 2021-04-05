//
//  TransactionItemView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 29/03/2021.
//

import SwiftUI

struct TransactionItemView: View {
       var image: String
        var title: String
        var price: Double
        var date : String;
        
        var body: some View {
            HStack(alignment: .center) {
                Image(image)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 20)
                   
                
                VStack(alignment: .leading) {
                    
                    HStack{
                        VStack{
                            Text(title)
                                .font(.system(size: 14, weight: .bold, design: .default))
                                .foregroundColor(.black).padding(.leading)
                            Text(date)
                                .font(.system(size: 14, weight: .light, design: .default))
                                .foregroundColor(.gray).padding(.leading)
                        }
                       
                    
                        Spacer()
                        
                        Text("RM" + String.init(format: "%0.2f", price))
                            .font(.system(size: 16, weight: .bold, design: .default))
                            .foregroundColor(.black)
                            .padding(.top, 8)
                        
                    }
                 
                }.padding(.trailing, 10)
            }
            .frame(maxWidth: .infinity, alignment: .center)
            .padding(.all, 2)
        }
}

