def call(Map params){
    pipeline{
        stages{
            stage("Construyendo docker"){
                steps{
                    script{
                        sh : myDockerLib.build(rutaArchivoDocker: "${params.rutaArchivoDocker}",
                                            nombreImagenDocker: "${params.nombreImagenDocker}",
                                            carpetaDocker: "${params.carpetaDocker}")
                        }
                }
                
            }

            stage("Pusheando docker"){
                steps{
                    script{
                        sh : myDockerLib.push(nombreImagenDocker: "${params.nombreImagenDocker}")
                    }
                }
                
            }
        }
    }
}
