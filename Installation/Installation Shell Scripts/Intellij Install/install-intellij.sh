
#!/bin/sh
 
cd ~/Downloads

wget "https://download.jetbrains.com/idea/ideaIC-2021.3.tar.gz?_gl=1*14ggh2a*_ga*MTk0NjM1MjAzNS4xNjQwNTk3NTQz*_ga_V0XZL7QHEB*MTY0MDU5NzU0My4xLjEuMTY0MDU5NzgxOS4w&_ga=2.226875417.589077562.1640597544-1946352035.1640597543"

mv "ideaIC-2021.3.tar.gz?_gl=1*14ggh2a*_ga*MTk0NjM1MjAzNS4xNjQwNTk3NTQz*_ga_V0XZL7QHEB*MTY0MDU5NzU0My4xLjEuMTY0MDU5NzgxOS4w&_ga=2.226875417.589077562.1640597544-1946352035.1640597543" "ideaIC-2021.3.tar.gz"

sudo tar -xvzf ideaIC-2021.3.tar.gz 

cd ~/Downloads/

ls

cd idea-IC-213.5744.223//bin

./idea.sh
