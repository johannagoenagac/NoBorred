package org.alkemy.accenture.views.data

interface ResponseListener<T> {
    fun onResponse(response: RepositoryResponse<T>)

    fun onError(repositoryError: RepositoryError)
}