//
//  LoginHeader.swift
//  iosApp
//
//  Created by Natneal Asmelash on 9/21/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HeaderView: View {
    let title: String
    let subtitle: String
    let angle: Double
    let background: Color
    
    var body: some View {
        //Header
        ZStack {
            RoundedRectangle(cornerRadius: 0)
                .foregroundColor(background)
                .rotationEffect(Angle(degrees: angle))

            VStack {
                Text(title)
                    .font(.system(size: 46))
                    .foregroundColor(Color.white)
                    .bold()
                Text(subtitle)
                    .font(.system(size: 24))
                    .foregroundColor(Color.white)
            }
            .padding(.top, 124)
        }
        .frame(width: UIScreen.main.bounds.width * 3, height: 350)
        .offset(y: -150)
    }
}

#Preview {
    HeaderView(title: "Title", subtitle: "Subtitle", angle: 15, background: .blue)
}
