# Simplified snowflake variant: [1b(0) || 38b(timestamp_{10ms}) || 16b(assigner_hash) || 9b(sequence)]
# - derive_id(assigner: id) -> id

__all__ = ["derive_id"]

import time
import datetime
from hashlib import sha256


LAST_TIMESTAMP = 0
LAST_SEQUENCE = 0
ORIGIN = int(
    datetime.datetime(2024, 1, 1, 0, 0, 0).timestamp() * 100
)  # 2024-01-01 00:00:00, 10ms precision


def folded_hash(data: int):
    # folded_hash data = foldl1 xor (map fromIntegral . B.unpack) . chunksOf 2 $ sha256 data
    hash = sha256(data.to_bytes(16, byteorder="big")).digest()
    chunks = [hash[i : i + 2] for i in range(0, len(hash), 2)]
    folded = chunks[0]
    for chunk in chunks[1:]:
        folded = bytes([a ^ b for a, b in zip(folded, chunk)])
    return int.from_bytes(folded, byteorder="big")


def derive_id(assigner: int):
    global LAST_TIMESTAMP
    global LAST_SEQUENCE

    timestamp = int(time.time() * 100) - ORIGIN
    if timestamp == LAST_TIMESTAMP:
        LAST_SEQUENCE = (LAST_SEQUENCE + 1) % 512
    else:
        LAST_SEQUENCE = 0
        LAST_TIMESTAMP = timestamp

    return (timestamp << 25) | (folded_hash(assigner) << 9) | LAST_SEQUENCE
