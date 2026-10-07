from routes.router import routes # -> absolute import
from ..routes.router import routes # -> relative import

# __init__ file 
# 1. helps in controlling which modules & functions are exposed
# out of the module. 
# 2. setup initialization logic for a package. Whenever a file imports
# this package, this initialization logic will get executed.

# absolute imports - specifies the full path of the module from the project's root directory
# relative imports - specifies the path of the module relative to the file where it is getting imported.