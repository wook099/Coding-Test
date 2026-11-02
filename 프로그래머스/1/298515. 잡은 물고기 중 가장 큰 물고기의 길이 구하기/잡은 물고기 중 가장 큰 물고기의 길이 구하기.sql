select concat(Length,'cm') as MAX_LENGTH
from FISH_INFO
order by Length desc
Limit 1;
