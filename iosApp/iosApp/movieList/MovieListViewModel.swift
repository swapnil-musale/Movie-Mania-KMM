//
//  MovieListViewModel.swift
//  iosApp
//
//  Created by Swapnil Musale on 26/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@available(iOS 16.0, *)
extension MovieListView {
    @MainActor class MovieListViewModel: ObservableObject {
        
        private var currentPageNo = 1
        private let getMovieListUseCase = GetMovieListUseCase.init()
        
        @Published private(set) var movies:[Movie] = []
        @Published private(set) var isLoading:Bool = false
        @Published private(set) var isLoadingFinished:Bool = false
        
        func getMovieList() async {
            if isLoading { return }
            
            do {
                let response = try await getMovieListUseCase.invoke(pageNo: Int32(currentPageNo))
                isLoading = false
                isLoadingFinished = response.movieList.isEmpty
                
                currentPageNo += 1
                self.movies = self.movies + response.movieList
            } catch {
                isLoading = false
                isLoadingFinished = true
            }
        }
    }
}
