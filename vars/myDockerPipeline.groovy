def call(Map params){
    pipeline{
        anget any
        
        stages{
            stage("Construyendo docker"){
                script{
                    sh : myDockerLib.build(rutaArchivoDocker: "${params.rutaArchivoDocker}",
                                          nombreImagenDocker: "${params.nombreImagenDocker}",
                                          carpetaDocker: "${params.carpetaDocker}")
                }
            }

            stage("Pusheando docker"){
                script{
                    sh : myDockerLib.push(nombreImagenDocker: "${params.nombreImagenDocker}")
                }
            }
        }

    }
}
