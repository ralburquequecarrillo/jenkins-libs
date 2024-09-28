def build(Map params){
    sh: "docker build -f " ${params.rutaArchivoDocker} + "-t " ${params.nombreImagenDocker} + ${params.carpetaDocker}
}

def push(Map params){
    sh: "docker push "+ ${params.nombreImagenDocker}
}