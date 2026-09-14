#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPORT_DIR="${SCRIPT_DIR}/../reports"
mkdir -p "${REPORT_DIR}"

if ! command -v jmeter >/dev/null 2>&1; then
  echo "JMeter not found in PATH. Install JMeter and rerun the script."
  exit 1
fi

jmeter -n \
  -t "${SCRIPT_DIR}/OrderLoadTest.jmx" \
  -l "${REPORT_DIR}/result.jtl"

jmeter -g "${REPORT_DIR}/result.jtl" \
  -o "${REPORT_DIR}/html"
