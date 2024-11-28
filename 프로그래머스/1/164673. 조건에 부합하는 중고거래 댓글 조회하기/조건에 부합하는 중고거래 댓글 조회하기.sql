select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, left(r.CREATED_DATE, 10) CREATED_DATE
from USED_GOODS_BOARD b join USED_GOODS_REPLY r
on b.BOARD_ID = r.BOARD_ID
where year(b.CREATED_DATE) = 2022 and month(b.CREATED_DATE) = 10
order by r.CREATED_DATE, b.TITLE