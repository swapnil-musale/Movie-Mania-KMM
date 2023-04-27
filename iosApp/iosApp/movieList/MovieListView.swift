import SwiftUI
import shared

@available(iOS 16.0, *)
struct MovieListView: View {
	
    @StateObject var viewModel = MovieListViewModel()
    let gridItems: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16 ), count:2)
    
    @available(iOS 16.0, *)
    var body: some View {
        NavigationStack {
            ScrollView {
                LazyVGrid(columns: gridItems, spacing: 16) {
                    ForEach(viewModel.movies, id: \.id) { movie in
                        NavigationLink(value: movie) {
                            MovieListItem(movie: movie)
                                .task {
                                    if movie == viewModel.movies.last && !viewModel.isLoading && !viewModel.isLoadingFinished {
                                        await viewModel.getMovieList()
                                    }
                                }
                        }
                        .buttonStyle(PlainButtonStyle())
                    }
                    
                    if viewModel.isLoading {
                        Section(footer: ProgressView()) {}
                    }
                    
                }.padding(.horizontal, 12)
                    .navigationDestination(for: Movie.self) { movie in
                        MovieDetailsView(movie: movie)
                    }
                
            }.navigationTitle("Movie Mania")
        }.task {
            await viewModel.getMovieList()
        }
    }
}

@available(iOS 16.0, *)
struct MovieListView_Previews: PreviewProvider {
	static var previews: some View {
		MovieListView()
	}
}
