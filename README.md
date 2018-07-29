# JavaSeniorBrunoMathidios

### Instructions

After cloning the application and before run it:

Go go **resources/docker/mysql** folder and run the following instruction:

*docker-compose up*

To access the database, open another terminal and run the instruction below:

*docer exec -it colaboradores_mysql bash*

Then:

*mysql -u colab -p*

Password:

*colab321*

And finally run the instruction below to start using the **colaboradores** database:

*use colaboradores;*
